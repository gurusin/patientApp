import {Component, OnInit} from '@angular/core';
import {ItemProductService} from "../../services/itemProduct.service";

@Component({
    selector: 'app-medical-service-component',
    templateUrl: './medical-service-component.component.html',
    styleUrls: ['./medical-service-component.component.css']
})
export class MedicalServiceComponentComponent implements OnInit {

    medicalServices = [];
    item: any;
    productTypes =[];

    constructor(private prodTypeService:ItemProductService) {
       this.onNew();
    }

    onNew()
    {
        this.item = new Object();
        this.item.productType= new Object();
    }

    cancelEdit() {
       this.onNew();
    }

    setClickedRow(i)
    {
        this.item = Object.assign({},this.medicalServices[i]);
    }

    onSubmit() {
        this.prodTypeService.saveMedicalService(this.item).subscribe(
            data =>{
                this.medicalServices =data;
                this.onNew();
            }
        );
    }

    ngOnInit() {
        this.prodTypeService.getProductTypes().subscribe(
          data =>{this.productTypes =data;}
        );

        this.prodTypeService.getAllMedicalServices().subscribe(
            data =>{
                this.medicalServices = data;
            }
        );
    }

}
