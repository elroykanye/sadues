import {environment} from "../environments/environment";

const serverApiUrl = `${environment.serverUrl}/api`;

// academic year, assoc, dues-info, dues payment, university, membership, user
export const ACADEMIC_YEAR_API_URL = `${serverApiUrl}/academic_year`;
export const ASSOC_API_URL = `${serverApiUrl}/assoc`;
export const AUTH_API_URL = `${serverApiUrl}/auth`;
export const DUES_INFO_API_URL = `${serverApiUrl}/dues_info`;
export const DUES_PAYMENT_API_URL = `${serverApiUrl}/dues_payment`;
export const MEMBERSHIP_API_URL = `${serverApiUrl}/membership`;
export const UNIVERSITY_API_URL = `${serverApiUrl}/user`;
export const USER_API_URL = `${serverApiUrl}/university`;
