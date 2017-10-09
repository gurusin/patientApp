import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Patientvisit} from "./patientvisit";
import {ItemProductService} from "../services/itemProduct.service";
import {forEach} from "@angular/router/src/utils/collection";


@Component({
    selector: 'app-service-component',
    templateUrl: './service-component.component.html',
    styleUrls: ['./service-component.component.css']
})
export class ServiceComponentComponent implements OnInit {

    @Input() patientVisit: Patientvisit;
    @Output() serviceAdded: EventEmitter<number> = new EventEmitter<number>();
    @Output() serviceRemoved:EventEmitter<number> = new EventEmitter<number>();
    medicalServices = [];
    servicesTotal = 0;

    constructor(private prodTypeService: ItemProductService) {
    }

    ngOnInit() {
        this.prodTypeService.getAllMedicalServices().subscribe(
            data => {
                this.medicalServices = data;
                this.serviceChanged(0,0);
                var x =Object.assign({},this.medicalServices[0]);
                this.patientVisit.medicalServices.push(x);
               this.calculateTotal();
            }
        );
    }

    calculateTotal()
    {
      this.servicesTotal = 0;
      this.patientVisit.medicalServices.forEach(item =>{
        this.servicesTotal += item.unitPrice;
      });
      this.serviceAdded.emit(this.servicesTotal);

    }

    serviceChanged(itemId,rowIndex) {
        this.medicalServices.forEach(child=>{
            if (itemId == child.itemId)
            {
                this.patientVisit.medicalServices[rowIndex] = Object.assign({},child);
            }
        });
        this.calculateTotal();
    }



    onAdd()
    {
        this.patientVisit.medicalServices.unshift(new Object());
    }

    onRemove(i)
    {
        if (i>0)
        {
          this.patientVisit.medicalServices.splice(i);
        }
        this.calculateTotal();
    }

}
