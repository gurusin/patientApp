import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'drugPackagePipe'
})
export class DrugPackagePipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if (value.length ===1)
    {
      return null;
    }
    let filter = args;
    return value.filter(data=>
      data.drug.brandName.indexOf(filter) !== -1);
  }

}
