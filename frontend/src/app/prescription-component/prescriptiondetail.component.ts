import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-prescriptiondetail',
  templateUrl: './prescriptiondetail.component.html',
  styleUrls: ['./prescriptiondetail.component.css']
})
export class PrescriptiondetailComponent implements OnInit {
  @Input() prescription;

  ngOnInit() {
  }

}
