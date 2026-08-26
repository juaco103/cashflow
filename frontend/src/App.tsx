import { useCallback, useEffect, useState } from 'react';
import Container from '@mui/material/Container';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import GastoForm from './components/GastoForm';
import GastoList from './components/GastoList';
import { listarGastos } from './api/gastoService';
import type { Gasto } from './types/gasto';

function App() {
  const [gastos, setGastos] = useState<Gasto[]>([]);

  const cargarGastos = useCallback(async () => {
    const datos = await listarGastos();
    setGastos(datos);
  }, []);

  useEffect(() => {
    cargarGastos();
  }, [cargarGastos]);

  return (
    <Container maxWidth="md" sx={{ py: 4 }}>
      <Typography variant="h4" component="h1" gutterBottom>
        CashFlow
      </Typography>
      <Box sx={{ mb: 4 }}>
        <GastoForm onGastoRegistrado={cargarGastos} />
      </Box>
      <GastoList gastos={gastos} />
    </Container>
  );
}

export default App;
