import {Injectable} from '@angular/core';
import {Itemproduct} from "../item/itemproduct";
import {HttpServiceService} from "../service/http-service.service";
import {Observable} from "rxjs";

@Injectable()
export class ItemProductService {

    public itemproductObject: Itemproduct;

    constructor(private http: HttpServiceService) {
        this.itemproductObject = new Itemproduct();
    }

    loadItemProducts(): Observable<any[]> {
        var url =  "loadItems";
        return this.http.sendGet(url);
    }

    saveItemProduct(itemproduct: any) {
        var url =  "saveItem";
        return this.http.sendPost(url, itemproduct).subscribe(
            data => {
                this.itemproductObject = data;
            }
        );
    }

    getProductTypes(): Observable<any> {
        var url =  "getProductTypes"
        return this.http.sendGet(url);

    }

    saveMedicalService(medItem: any) {
        var url = "saveMedicalServiceItem";
        return this.http.sendPost(url, medItem);
    }

    getAllMedicalServices(): Observable<any> {
        var url = "getMedicalServices";
        return this.http.sendGet(url);
    }
}
