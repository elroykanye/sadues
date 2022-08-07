import {AcademicYearService} from "./service/academic-year.service";
import {AssocService} from "./service/assoc.service";
import {AuthService} from "./service/auth.service";
import {DuesInfoService} from "./service/dues-info.service";
import {DuesPaymentService} from "./service/dues-payment.service";
import {MembershipService} from "./service/membership.service";
import {UserService} from "./service/user.service";
import {UniversityService} from "./service/university.service";
import {environment} from "../environments/environment";
import {
  ACADEMIC_YEAR_API_URL,
  ASSOC_API_URL,
  AUTH_API_URL,
  DUES_INFO_API_URL,
  DUES_PAYMENT_API_URL, MEMBERSHIP_API_URL, UNIVERSITY_API_URL, USER_API_URL
} from "./app.constants";


const academicYearInjectable: Array<any> = [
  {provide: AcademicYearService, useClass: AcademicYearService},
  {provide: ACADEMIC_YEAR_API_URL, useValue: ACADEMIC_YEAR_API_URL}
];
const assocInjectable: Array<any> = [
  {provide: AssocService, useClass: AssocService},
  {provide: ASSOC_API_URL, useValue: ASSOC_API_URL}
];
const authInjectable: Array<any> = [
  {provide: AuthService, useClass: AuthService},
  {provide: AUTH_API_URL, useValue: AUTH_API_URL}
];
const duesInfoInjectable: Array<any> = [
  {provide: DuesInfoService, useClass: DuesInfoService},
  {provide: DUES_INFO_API_URL, useValue: DUES_INFO_API_URL}
];
const duesPaymentInjectable: Array<any> = [
  {provide: DuesPaymentService, useClass: DuesPaymentService},
  {provide: DUES_PAYMENT_API_URL, useValue: DUES_PAYMENT_API_URL}
];
const membershipInjectable: Array<any> = [
  {provide: MembershipService, useClass: MembershipService},
  {provide: MEMBERSHIP_API_URL, useValue: MEMBERSHIP_API_URL}
];
const userInjectable: Array<any> = [
  {provide: UserService, useClass: UserService},
  {provide: USER_API_URL, useValue: USER_API_URL}
];
const universityInjectable: Array<any> = [
  {provide: UniversityService, useClass: UniversityService},
  {provide: UNIVERSITY_API_URL, useValue: UNIVERSITY_API_URL}
];

export const SERVICE_INJECTABLES = [
  academicYearInjectable,
  assocInjectable,
  authInjectable,
  duesInfoInjectable,
  duesPaymentInjectable,
  membershipInjectable,
  userInjectable,
  universityInjectable
];
