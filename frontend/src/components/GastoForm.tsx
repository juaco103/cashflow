import { useState, type FormEvent } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import Alert from '@mui/material/Alert';
import { registrarGasto } from '../api/gastoService';

interface GastoFormProps {
  onGastoRegistrado: () => void;
}

function GastoForm({ onGastoRegistrado }: GastoFormProps) {
  const [descripcion, setDescripcion] = useState('');
  const [valor, setValor] = useState('');
  const [fechaVencimiento, setFechaVencimiento] = useState('');
  const [error, setError] = useState<string | null>(null);

  async function handleSubmit(event: FormEvent) {
    event.preventDefault();
    setError(null);  

    try {
      await registrarGasto({
        descripcion,
        valor: Number(valor),
        fechaVencimiento: fechaVencimiento || null,
      });    

      setDescripcion('');
      setValor('');
      setFechaVencimiento('');
      onGastoRegistrado();
    } catch {
      setError('No se pudo registrar el gasto. Revisa los datos e intenta de nuevo.');
    }
  }      

  return (
    <Box component="form" onSubmit={handleSubmit} sx={{ mb: 3 }}>
      <Stack direction="row" spacing={2} alignItems="flex-start" flexWrap="wrap">
        <TextField
          label="Descripción"
          value={descripcion}
          onChange={(e) => setDescripcion(e.target.value)}
          required
        />
        <TextField
          label="Valor"
          type="number"
          value={valor}
          onChange={(e) => setValor(e.target.value)}
          required
        />
        <TextField
          label="Fecha de vencimiento"
          type="date"
          value={fechaVencimiento}
          onChange={(e) => setFechaVencimiento(e.target.value)}
          slotProps={{ inputLabel: { shrink: true } }}
        />
        <Button type="submit" variant="contained">
          Registrar
        </Button>
      </Stack>
      {error && <Alert severity="error" sx={{ mt: 2 }}>{error}</Alert>}
    </Box>
  );
}

export default GastoForm;