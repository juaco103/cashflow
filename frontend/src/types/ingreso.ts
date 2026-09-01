export interface Ingreso {
  id: number;
  descripcion: string;
  valor: number;
  fecha: string | null;
  fechaCreacion: string;
}

export interface NuevoIngreso {
  descripcion: string;
  valor: number;
  fecha?: string | null;
}