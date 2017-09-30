import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'patientAdminFilter'
})
export class PatientAdminFilterPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if (args.length ===1 || args.length==0)
    {
      return value;
    }
    let filter = args;
    return value.filter(data=>
      data.firstname.indexOf(filter) !== -1 ||
      data.lastname.indexOf(filter) !== -1 ||
      filter.length ===0
    );
  }


}
