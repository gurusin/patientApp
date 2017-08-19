import {Basedrug} from "./basedrug";

export class Drug {
   drugId:"";
   baseDrug: Basedrug;
   brandName:"";

   constructor()
   {
     this.baseDrug =new Basedrug();
     this.brandName="";
   }
}
