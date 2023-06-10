import { WebPlugin } from '@capacitor/core';

import type { Manage_All_AccessPlugin } from './definitions';

export class Manage_All_AccessWeb extends WebPlugin implements Manage_All_AccessPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
