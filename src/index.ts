import { registerPlugin } from '@capacitor/core';

import type { Manage_All_AccessPlugin } from './definitions';

const Manage_All_Access = registerPlugin<Manage_All_AccessPlugin>('Manage_All_Access', {
  web: () => import('./web').then(m => new m.Manage_All_AccessWeb()),
});

export * from './definitions';
export { Manage_All_Access };
