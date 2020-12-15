import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizarHorarioComponent } from './actualizar-horario.component';

describe('ActualizarHorarioComponent', () => {
  let component: ActualizarHorarioComponent;
  let fixture: ComponentFixture<ActualizarHorarioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActualizarHorarioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActualizarHorarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
