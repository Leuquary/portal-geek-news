import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeituraComponent } from './leitura.component';

describe('LeituraComponent', () => {
  let component: LeituraComponent;
  let fixture: ComponentFixture<LeituraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LeituraComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LeituraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
