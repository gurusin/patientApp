import {Directive, HostBinding, HostListener} from '@angular/core';

@Directive({
  selector: '[appSelectedRow]'
})
export class SelectedRowDirective {

    @HostBinding('style.backgroundColor') c_colorrr = "red";

    constructor() { }

    setClickedRow(i)
    {

    }

    @HostListener('mouseenter') c_onEnterrr() {
        this.c_colorrr= "blue" ;
    }

    @HostListener('mouseleave') c_onLeaveee() {
        this.c_colorrr = "yellow" ;
    }

}
