import {Component, Input, OnInit} from '@angular/core';
import {Patientvisit} from "./patientvisit";
import {ItemProductService} from "../services/itemProduct.service";

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
                this.patientVisit.medicalServices.push(new Object());
            }
        );
    }

    serviceChanged(i,j) {
        this.patientVisit.medicalServices[j] = Object.assign({},this.medicalServices[i]);
        this.patientVisit.medicalServices[j].serviceIndex =i;
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
