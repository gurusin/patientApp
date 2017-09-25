import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'patient'
})
export class PatientPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if (value.length ===1)
    {
      return null;
    }
    let filter = args;
    return value.filter(data=>
      data.patient.firstname.indexOf(filter) !== -1 ||
      data.patient.lastname.indexOf(filter) !== -1
    );
  }

}
