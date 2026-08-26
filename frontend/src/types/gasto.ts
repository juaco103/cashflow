export type EstadoGasto = 'PENDIENTE' | 'PARCIALMENTE_PAGADO' | 'PAGADO';

export interface Gasto {
  id: number;
  descripcion: string;
  valor: number;
  montoPagado: number;
  pendiente: number;
  estado: EstadoGasto;
  fechaVencimiento: string | null;
  fechaCreacion: string;
}

export interface NuevoGasto {
  descripcion: string;
  valor: number;
  montoPagado?: number;
  fechaVencimiento?: string | null;
}