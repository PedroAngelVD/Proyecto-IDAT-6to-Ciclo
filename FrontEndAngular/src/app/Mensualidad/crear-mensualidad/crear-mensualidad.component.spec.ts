import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearMensualidadComponent } from './crear-mensualidad.component';

describe('CrearMensualidadComponent', () => {
  let component: CrearMensualidadComponent;
  let fixture: ComponentFixture<CrearMensualidadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CrearMensualidadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearMensualidadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
