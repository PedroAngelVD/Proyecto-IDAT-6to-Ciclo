import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarPagoReinscripcionComponent } from './listar-pago-reinscripcion.component';

describe('ListarPagoReinscripcionComponent', () => {
  let component: ListarPagoReinscripcionComponent;
  let fixture: ComponentFixture<ListarPagoReinscripcionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListarPagoReinscripcionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarPagoReinscripcionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
