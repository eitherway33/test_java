import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';
import { Router, ActivatedRoute } from '@angular/router';


//import swal from 'sweetalert2';
@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls:['./form.component.css'],
  encapsulation: ViewEncapsulation.None
}) 


export class FormComponent implements OnInit { 
  public cliente:Cliente = new Cliente();
  public titulo:string = 'Crear usuario';
  constructor(private clienteService:ClienteService,
              private router:Router,
              private activatedRoute:ActivatedRoute,  
            ) {}


  ngOnInit(): void {
    this.cargarCliente(); 
  } 

  cargarCliente(): void{
    this.activatedRoute.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.clienteService.getCliente(id).subscribe((cliente) => this.cliente = cliente);
      }
    })
  }

  update():void{
    this.clienteService.update(this.cliente)
      .subscribe( cliente => {
        this.router.navigate(['/clientes']);
        //swal.fire('Usuario Actualizado', `usuario ${cliente.nombre} actualiado con exito`,'success');
      }

      )
  }

  public create(): void{
    this.clienteService.create(this.cliente).subscribe(
      cliente => {
        this.router.navigate(['/clientes']);
        //swal.fire('Nuevo Usuario', `usuario ${cliente.nombre} creado con exito`,'success');
      }
    );
  }

  public redirigir():void{
    this.router.navigate(['/clientes']);
  }



}
