import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import type { Ingreso } from '../types/ingreso';

function formatearMoneda(valor: number): string {
  return valor.toLocaleString('es-CO', { style: 'currency', currency: 'COP', maximumFractionDigits: 0 });
}

interface IngresoListProps {
  ingresos: Ingreso[];
}

function IngresoList({ ingresos }: IngresoListProps) {
  return (
    <TableContainer component={Paper}>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>Descripción</TableCell>
            <TableCell align="right">Valor</TableCell>
            <TableCell>Fecha</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {ingresos.map((ingreso) => (
            <TableRow key={ingreso.id}>
              <TableCell>{ingreso.descripcion}</TableCell>
              <TableCell align="right">{formatearMoneda(ingreso.valor)}</TableCell>
              <TableCell>{ingreso.fecha ?? '—'}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}

export default IngresoList;