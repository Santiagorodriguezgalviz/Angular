

import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-module',
  standalone: true,
  imports: [HttpClientModule, FormsModule, CommonModule],
  templateUrl: './module.component.html',
  styleUrl: './module.component.css'
})

export class ModuleComponent implements OnInit {
  modules: any[] = [];
  module: any = { id: 0, nombre: '', descripcion: '', state: false };

  private apiUrl = 'https://localhost:44371/Module';  

  constructor(private http: HttpClient, private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.getModules();
  }

  getModules(): void {
    this.http.get<any[]>(this.apiUrl).subscribe(
      (modules) => {
        this.modules = modules;
        this.cdr.detectChanges();
        console.log('Modules fetched:', this.modules);
      },
      (error) => {
        console.error('Error fetching modules:', error);
      }
    );
  }

  onSubmit(form: NgForm): void {
    if (this.module.id === 0) {
      // Agregar un nuevo registro
      this.http.post(this.apiUrl, this.module).subscribe(() => {
        this.getModules();  
        form.resetForm();  
        this.resetForm();  
        Swal.fire('Success', 'Module created successfully!', 'success');
      });
    } else {
      // Actualizar un registro existente
      this.http.put(`${this.apiUrl}/${this.module.id}`, this.module).subscribe(() => {
        this.getModules();
        form.resetForm();
        this.resetForm();
        Swal.fire('Success', 'Module updated successfully!', 'success');
      });
    }
  }

  editModule(module: any): void {
    this.module = { ...module };
  }

  deleteModule(id: number): void {
    Swal.fire({
      title: 'Are you sure?',
      text: 'You won\'t be able to revert this!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, cancel!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        this.http.delete(`${this.apiUrl}/${id}`).subscribe(() => {
          this.getModules();
          Swal.fire(
            'Deleted!',
            'Your module has been deleted.',
            'success'
          );
        });
      } else if (result.dismiss === Swal.DismissReason.cancel) {
        Swal.fire(
          'Cancelled',
          'Your module is safe :)',
          'error'
        );
      }
    });
  }

  resetForm(): void {
    this.module = { id: 0, nombre: '', descripcion: '', state: false };
  }
}
