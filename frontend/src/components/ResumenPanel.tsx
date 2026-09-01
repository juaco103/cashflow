import Grid from '@mui/material/Grid';
import Paper from '@mui/material/Paper';
import Typography from '@mui/material/Typography';
import type { Resumen } from '../types/resumen';

function formatearMoneda(valor: number): string {
  return valor.toLocaleString('es-CO', { style: 'currency', currency: 'COP', maximumFractionDigits: 0 });
}

interface ResumenPanelProps {
  resumen: Resumen;
}

function ResumenPanel({ resumen }: ResumenPanelProps) {
  const colorSaldo = resumen.saldoDisponible >= 0 ? 'success.main' : 'error.main';

  return (
    <Grid container spacing={2} sx={{ mb: 3 }}>
      <Grid size={{ xs: 6, sm: 3 }}>
        <Paper sx={{ p: 2 }}>
          <Typography variant="body2" color="text.secondary">Ingresos</Typography>
          <Typography variant="h6">{formatearMoneda(resumen.totalIngresos)}</Typography>
        </Paper>
      </Grid>
      <Grid size={{ xs: 6, sm: 3 }}>
        <Paper sx={{ p: 2 }}>
          <Typography variant="body2" color="text.secondary">Gastos</Typography>
          <Typography variant="h6">{formatearMoneda(resumen.totalGastos)}</Typography>
        </Paper>
      </Grid>
      <Grid size={{ xs: 6, sm: 3 }}>
        <Paper sx={{ p: 2 }}>
          <Typography variant="body2" color="text.secondary">Pendiente</Typography>
          <Typography variant="h6">{formatearMoneda(resumen.totalPendiente)}</Typography>
        </Paper>
      </Grid>
      <Grid size={{ xs: 6, sm: 3 }}>
        <Paper sx={{ p: 2 }}>
          <Typography variant="body2" color="text.secondary">Saldo disponible</Typography>
          <Typography variant="h6" sx={{ color: colorSaldo }}>
            {formatearMoneda(resumen.saldoDisponible)}
          </Typography>
        </Paper>
      </Grid>
    </Grid>
  );
}

export default ResumenPanel;