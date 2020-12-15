import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearReinscripcionComponent } from './crear-reinscripcion.component';

describe('CrearReinscripcionComponent', () => {
  let component: CrearReinscripcionComponent;
  let fixture: ComponentFixture<CrearReinscripcionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CrearReinscripcionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearReinscripcionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
