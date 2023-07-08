export interface Manage_All_AccessPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  requestAllFilesAccessPermission(): Promise<void>;
  checkAllFilesAccessPermission(): Promise<{hasPermission: boolean}>;
}
