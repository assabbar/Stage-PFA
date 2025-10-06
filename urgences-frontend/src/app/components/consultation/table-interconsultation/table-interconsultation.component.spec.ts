import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableInterconsultationComponent } from './table-interconsultation.component';

describe('TableInterconsultationComponent', () => {
  let component: TableInterconsultationComponent;
  let fixture: ComponentFixture<TableInterconsultationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TableInterconsultationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TableInterconsultationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
