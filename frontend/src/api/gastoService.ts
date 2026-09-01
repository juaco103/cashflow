import axiosClient from './axiosClient';
import type { Gasto, NuevoGasto } from '../types/gasto';

export async function listarGastos(): Promise<Gasto[]> {
  const response = await axiosClient.get<Gasto[]>('/gastos');
  return response.data;
}

export async function registrarGasto(nuevoGasto: NuevoGasto): Promise<Gasto> {
  const response = await axiosClient.post<Gasto>('/gastos', nuevoGasto);
  return response.data;
}