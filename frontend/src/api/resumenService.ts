import axiosClient from './axiosClient';
import type { Resumen } from '../types/resumen';

export async function obtenerResumen(): Promise<Resumen> {
  const response = await axiosClient.get<Resumen>('/resumen');
  return response.data;
}