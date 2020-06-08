import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import {ClienteService} from './cliente.service';
import Swal from 'sweetalert2';
import { Subject } from 'rxjs'; 



@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls:['./clientes.component.css'],

  
})  

export class ClientesComponent implements OnInit { 

  user$: any[]= []; 
  dtOptions: DataTables.Settings={} 
  dtTrigger: Subject<any> = new Subject(); 
  //Inyección de dependencias
  constructor(private clienteService:ClienteService) { }
  //el evento ngOnInit se emplea cuando se inicializa un evento
  ngOnInit() { 
    this.dtOptions= {
      pagingType: 'full_numbers',
      pageLength: 5,
      //responsive:true,
      scrollX: true,
      scrollY: '300',  

    };
    this.clienteService.getClientes().subscribe(
       clienteService=> {this.user$= clienteService;
       this.dtTrigger.next(); 
       });
  }

  delete(cliente: Cliente):void{
    const swalWithBootstrapButtons = Swal.mixin({
    customClass: {
      confirmButton: 'btn btn-success',
      cancelButton: 'btn btn-danger'
    },
    buttonsStyling: false
  })

  swalWithBootstrapButtons.fire({
    title: '¿Estas seguro?',
    text: `¿Desea eliminar al usuario ${cliente.userName} ${cliente.userLastName}?`,
    icon: 'warning',
    showCancelButton: true,
    confirmButtonText: '¡Eliminar!',
    cancelButtonText: '¡Cancelar!',
    reverseButtons: true
  }).then((result) => {
    if (result.value) {
      this.clienteService.delete(cliente.userId).subscribe(
        response => {
          this.user$ = this.user$.filter(cli => cli !== cliente);
          swalWithBootstrapButtons.fire(
            'Usuario eliminado!',
           // `Usuario ${cliente.nombre} elimiado con éxito`,
            'success'
          )
        }
      );

    }
  })
  }

}
