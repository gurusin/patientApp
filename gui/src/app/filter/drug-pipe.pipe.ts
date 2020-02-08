import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'drugPipe'
})
export class DrugPipePipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if (value.length ===1)
    {
      return null;
    }
    let filter = args;
    return value.filter(data=>
      data.brandName.indexOf(filter) !== -1);
  }

}
