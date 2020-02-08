import {Basedrug} from "./basedrug";

export class Drug {
   drugId:"";
   baseDrug: Basedrug;
   brandName:"";
   location:"";

   constructor()
   {
     this.baseDrug =new Basedrug();
     this.brandName="";
   }
}
