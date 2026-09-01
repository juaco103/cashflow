import { useState, type FormEvent } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import Alert from '@mui/material/Alert';
import { registrarIngreso } from '../api/ingresoService';

interface IngresoFormProps {
  onIngresoRegistrado: () => void;
}

function IngresoForm({ onIngresoRegistrado }: IngresoFormProps) {
  const [descripcion, setDescripcion] = useState('');
  const [valor, setValor] = useState('');
  const [fecha, setFecha] = useState('');
  const [error, setError] = useState<string | null>(null);

  async function handleSubmit(event: FormEvent) {
    event.preventDefault();
    setError(null);

    try {
      await registrarIngreso({
        descripcion,
        valor: Number(valor),
        fecha: fecha || null,
      });

      setDescripcion('');
      setValor('');
      setFecha('');
      onIngresoRegistrado();
    } catch {
      setError('No se pudo registrar el ingreso. Revisa los datos e intenta de nuevo.');
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
          label="Fecha"
          type="date"
          value={fecha}
          onChange={(e) => setFecha(e.target.value)}
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

export default IngresoForm;