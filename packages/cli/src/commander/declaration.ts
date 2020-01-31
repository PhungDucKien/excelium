import { Options } from 'yargs';

export const name = 'inversify-commander';

export const TYPE = {
  Group: Symbol.for(`${name}-Group`),
};

export interface GroupMetadata {
  name?: string;
  target: any;
  default: boolean;
}

export type TGroupsMetadata = GroupMetadata[];

export interface Option {
  key: string;
  options: Options;
}

export interface ActionMetadata {
  name?: string;
  key: string;
  target: any;
  default: boolean;
  options?: Option[];
  description?: string;
}

export type TActionsMetadata = ActionMetadata[];
