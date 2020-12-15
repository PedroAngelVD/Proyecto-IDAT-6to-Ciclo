import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarMensualidadComponent } from './listar-mensualidad.component';

describe('ListarMensualidadComponent', () => {
  let component: ListarMensualidadComponent;
  let fixture: ComponentFixture<ListarMensualidadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListarMensualidadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarMensualidadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
