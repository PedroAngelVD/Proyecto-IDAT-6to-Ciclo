import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizarReinscripcionComponent } from './actualizar-reinscripcion.component';

describe('ActualizarReinscripcionComponent', () => {
  let component: ActualizarReinscripcionComponent;
  let fixture: ComponentFixture<ActualizarReinscripcionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActualizarReinscripcionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActualizarReinscripcionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
