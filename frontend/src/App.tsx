import { useCallback, useEffect, useState } from 'react';
import Container from '@mui/material/Container';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import Divider from '@mui/material/Divider';
import GastoForm from './components/GastoForm';
import GastoList from './components/GastoList';
import IngresoForm from './components/IngresoForm';
import IngresoList from './components/IngresoList';
import ResumenPanel from './components/ResumenPanel';
import { listarGastos } from './api/gastoService';
import { listarIngresos } from './api/ingresoService';
import { obtenerResumen } from './api/resumenService';
import type { Gasto } from './types/gasto';
import type { Ingreso } from './types/ingreso';
import type { Resumen } from './types/resumen';

function App() {
  const [gastos, setGastos] = useState<Gasto[]>([]);
  const [ingresos, setIngresos] = useState<Ingreso[]>([]);
  const [resumen, setResumen] = useState<Resumen | null>(null);

  const cargarTodo = useCallback(async () => {
    const [gastosData, ingresosData, resumenData] = await Promise.all([
      listarGastos(),
      listarIngresos(),
      obtenerResumen(),
    ]);
    setGastos(gastosData);
    setIngresos(ingresosData);
    setResumen(resumenData);
  }, []);

  useEffect(() => {
    cargarTodo();
  }, [cargarTodo]);

  return (
    <Container maxWidth="md" sx={{ py: 4 }}>
      <Typography variant="h4" component="h1" gutterBottom>
        CashFlow
      </Typography>

      {resumen && <ResumenPanel resumen={resumen} />}

      <Typography variant="h6" gutterBottom>Gastos</Typography>
      <Box sx={{ mb: 2 }}>
        <GastoForm onGastoRegistrado={cargarTodo} />
      </Box>
      <GastoList gastos={gastos} />

      <Divider sx={{ my: 4 }} />

      <Typography variant="h6" gutterBottom>Ingresos</Typography>
      <Box sx={{ mb: 2 }}>
        <IngresoForm onIngresoRegistrado={cargarTodo} />
      </Box>
      <IngresoList ingresos={ingresos} />
    </Container>
  );  
}

export default App;