import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarReinscripcionComponent } from './listar-reinscripcion.component';

describe('ListarReinscripcionComponent', () => {
  let component: ListarReinscripcionComponent;
  let fixture: ComponentFixture<ListarReinscripcionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListarReinscripcionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarReinscripcionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
