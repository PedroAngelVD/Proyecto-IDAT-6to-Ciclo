import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizarMensualidadComponent } from './actualizar-mensualidad.component';

describe('ActualizarMensualidadComponent', () => {
  let component: ActualizarMensualidadComponent;
  let fixture: ComponentFixture<ActualizarMensualidadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActualizarMensualidadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActualizarMensualidadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
