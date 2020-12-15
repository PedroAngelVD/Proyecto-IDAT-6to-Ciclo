import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarPagoMensualidadComponent } from './listar-pago-mensualidad.component';

describe('ListarPagoMensualidadComponent', () => {
  let component: ListarPagoMensualidadComponent;
  let fixture: ComponentFixture<ListarPagoMensualidadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListarPagoMensualidadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarPagoMensualidadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
