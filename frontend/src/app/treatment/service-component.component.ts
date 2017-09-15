import {Component, Input, OnInit} from '@angular/core';
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
    medicalServices = [];

    constructor(private prodTypeService: ItemProductService) {
    }

    ngOnInit() {
        this.prodTypeService.getAllMedicalServices().subscribe(
            data => {
                this.medicalServices = data;
                this.serviceChanged(0,0);
                var x =Object.assign({},this.medicalServices[0]);
                this.patientVisit.medicalServices.push(x);
            }
        );
    }

    serviceChanged(itemId,rowIndex) {
        this.medicalServices.forEach(child=>{
            if (itemId == child.itemId)
            {
                this.patientVisit.medicalServices[rowIndex] = Object.assign({},child);
            }
        });

    }



    onAdd()
    {
        this.patientVisit.medicalServices.push(new Object());
    }

    onRemove(i)
    {
        this.patientVisit.medicalServices.splice(i);
    }


}
