import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'drugFilter'
})
export class FilterPipePipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if (value.length ===1)
    {
        return null;
    }
      let filter = args;
      return value.filter(data=>
      data.baseDrugName.indexOf(filter) !== -1);
  }
}
