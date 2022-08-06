import {AcademicYearService} from "./service/academic-year.service";
import {AssocService} from "./service/assoc.service";
import {DuesInfoService} from "./service/dues-info.service";
import {DuesPaymentService} from "./service/dues-payment.service";
import {MembershipService} from "./service/membership.service";
import {UserService} from "./service/user.service";
import {UniversityService} from "./service/university.service";

const serverApiUrl = 'http://localhost:8092/api';

// academic year, assoc, dues-info, dues payment, university, membership, user
export const ACADEMIC_YEAR_API_URL = "academic-year-api-url";
export const ASSOC_API_URL = "assoc-api-url";
export const DUES_INFO_API_URL = "dues-info-api-url";
export const DUES_PAYMENT_API_URL = "dues-payment-api-url";
export const MEMBERSHIP_API_URL = "membership-api-url";
export const UNIVERSITY_API_URL = "university-api-url";
export const USER_API_URL = "user-api-url";


const academicYearInjectable: Array<any> = [
  {provide: AcademicYearService, useClass: AcademicYearService},
  {provide: ACADEMIC_YEAR_API_URL, useValue: `${serverApiUrl}/academic_year`}
]
const assocInjectable: Array<any> = [
  {provide: AssocService, useValue: AssocService},
  {provide: ASSOC_API_URL, useValue: `${serverApiUrl}/assoc`}
]
const duesInfoInjectable: Array<any> = [
  {provide: DuesInfoService, useValue: DuesInfoService},
  {provide: DUES_INFO_API_URL, useValue: `${serverApiUrl}/dues_info`}
]
const duesPaymentInjectable: Array<any> = [
  {provide: DuesPaymentService, useValue: DuesPaymentService},
{provide: DUES_PAYMENT_API_URL, useValue: `${serverApiUrl}/dues_payment`}
]
const membershipInjectable: Array<any> = [
  {provide: MembershipService, useValue: MembershipService},
  {provide: MEMBERSHIP_API_URL, useValue: `${serverApiUrl}/membership`}
]
const userInjectable: Array<any> = [
  {provide: UserService, useValue: UserService},
  {provide: USER_API_URL, useValue: `${serverApiUrl}/user`}
]
const universityInjectable: Array<any> = [
  {provide: UniversityService, useValue: UniversityService},
  {provide: UNIVERSITY_API_URL, useValue: `${serverApiUrl}/university`}
]

export const SERVICE_INJECTABLES = [
  academicYearInjectable,
  assocInjectable,
  duesInfoInjectable,
  duesPaymentInjectable,
  membershipInjectable,
  userInjectable,
  universityInjectable
];
