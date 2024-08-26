import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-role',
  standalone: true,
  imports: [HttpClientModule, FormsModule, CommonModule],
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.css']
})
export class RoleComponent implements OnInit {
  roles: any[] = [];
  role: any = { id: 0, nombre: '', descripcion: '', state: false };

  private apiUrl = 'https://localhost:44371/Role';

  constructor(private http: HttpClient, private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.getRoles();
  }

  getRoles(): void {
    this.http.get<any[]>(this.apiUrl).subscribe(
      (roles) => {
        this.roles = roles;
        this.cdr.detectChanges();
        console.log('Roles fetched:', this.roles);
      },
      (error) => {
        console.error('Error fetching roles:', error);
      }
    );
  }

  onSubmit(form: NgForm): void {
    if (this.role.id === 0) {
      // Agregar un nuevo registro
      this.http.post(this.apiUrl, this.role).subscribe(() => {
        this.getRoles();  // Refresca la lista de roles
        form.resetForm();  // Resetea el formulario visualmente
        this.resetForm();  
        Swal.fire('Éxito', '¡Rol creado con éxito!', 'success');
      });
    } else {
      // Actualizar un registro existente
      this.http.put(`${this.apiUrl}/${this.role.id}`, this.role).subscribe(() => {
        this.getRoles();
        form.resetForm();
        this.resetForm();
        Swal.fire('Éxito', '¡Rol actualizado con éxito!', 'success');
      });
    }
  }

  editRole(role: any): void {
    this.role = { ...role };
  }

  deleteRole(id: number): void {
    Swal.fire({
      title: '¿Estás seguro?',
      text: '¡No podrás revertir esto!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Sí, ¡elimínalo!',
      cancelButtonText: 'No, cancelar',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        this.http.delete(`${this.apiUrl}/${id}`).subscribe(() => {
          this.getRoles();
          Swal.fire(
            '¡Eliminado!',
            'El rol ha sido eliminado.',
            'success'
          );
        });
      } else if (result.dismiss === Swal.DismissReason.cancel) {
        Swal.fire(
          'Cancelado',
          'El rol está a salvo :)',
          'error'
        );
      }
    });
  }

  resetForm(): void {
    this.role = { id: 0, nombre: '', descripcion: '', state: false };
  }
}
