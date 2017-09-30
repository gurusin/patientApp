import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'patient'
})
export class PatientPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if (args.length ===1 || args.length==0)
    {
      return value;
    }
    let filter = args;
    return value.filter(data=>
      data.patient.firstname.indexOf(filter) !== -1 ||
      data.patient.lastname.indexOf(filter) !== -1 ||
      filter.length ===0
    );
  }

}
