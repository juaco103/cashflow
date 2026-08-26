import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import type { Gasto } from '../types/gasto';

function formatearMoneda(valor: number): string {
  return valor.toLocaleString('es-CO', { style: 'currency', currency: 'COP', maximumFractionDigits: 0 });
}

interface GastoListProps {
  gastos: Gasto[];
}

function GastoList({ gastos }: GastoListProps) {
  return (
    <TableContainer component={Paper}>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>Descripción</TableCell>
            <TableCell align="right">Valor</TableCell>
            <TableCell align="right">Pagado</TableCell>
            <TableCell align="right">Pendiente</TableCell>
            <TableCell>Estado</TableCell>
            <TableCell>Vence</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {gastos.map((gasto) => (
            <TableRow key={gasto.id}>
              <TableCell>{gasto.descripcion}</TableCell>
              <TableCell align="right">{formatearMoneda(gasto.valor)}</TableCell>
              <TableCell align="right">{formatearMoneda(gasto.montoPagado)}</TableCell>
              <TableCell align="right">{formatearMoneda(gasto.pendiente)}</TableCell>
              <TableCell>{gasto.estado}</TableCell>
              <TableCell>{gasto.fechaVencimiento ?? '—'}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}

export default GastoList;