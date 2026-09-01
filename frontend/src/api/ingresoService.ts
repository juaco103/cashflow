import axiosClient from './axiosClient';
import type { Ingreso, NuevoIngreso } from '../types/ingreso';

export async function listarIngresos(): Promise<Ingreso[]> {
  const response = await axiosClient.get<Ingreso[]>('/ingresos');
  return response.data;
}

export async function registrarIngreso(nuevoIngreso: NuevoIngreso): Promise<Ingreso> {
  const response = await axiosClient.post<Ingreso>('/ingresos', nuevoIngreso);
  return response.data;
}
