import { CollectionUtil, StringUtil } from '@excelium/common';
import { Container } from 'inversify';
import { Argv } from 'yargs';
import { METADATA_KEY } from './constant';
import { GroupMetadata, Option, TActionsMetadata, TGroupsMetadata, TYPE } from './declaration';

export function getGroupsMetadata(): TGroupsMetadata {
  return Reflect.getMetadata(METADATA_KEY.group, Reflect);
}

export function getGroupPrototypeMetadata(group: any): GroupMetadata {
  return Reflect.getMetadata(METADATA_KEY.group, group);
}

export function getActionsPrototypeMetadata(group: any): TActionsMetadata {
  return Reflect.getMetadata(METADATA_KEY.action, group);
}

export function getGroupMetadata(instance: any): GroupMetadata {
  return getGroupPrototypeMetadata(instance.constructor);
}

export function getActionsMetadata(group: any): TActionsMetadata {
  return getActionsPrototypeMetadata(group.constructor);
}

export function registerGroups(container: Container) {
  const groupsMetadata = getGroupsMetadata();
  groupsMetadata.forEach(groupMetadata => {
    const constructor = groupMetadata.target;
    const name = constructor.name;
    if (container.isBoundNamed(TYPE.Group, name)) {
      throw new Error(DUPLICATED_GROUP_NAME(name));
    }
    container
      .bind(TYPE.Group)
      .to(constructor)
      .whenTargetNamed(name);
  });
}

export function build(program: Argv, container: Container) {
  const groups = container.getAll<any>(TYPE.Group);
  groups.forEach(groupContainer => {
    const groupMetadata = getGroupMetadata(groupContainer);
    const actionsMetadata = getActionsMetadata(groupContainer);
    actionsMetadata.forEach(actionMetadata => {
      const command = [] as string[];
      if (groupMetadata.name && StringUtil.isNotBlank(groupMetadata.name)) {
        if (actionMetadata.default) {
          command.push(groupMetadata.name);
        }
        if (actionMetadata.name && StringUtil.isNotBlank(actionMetadata.name)) {
          command.push(groupMetadata.name + ':' + actionMetadata.name);
        }
      }
      if (groupMetadata.default && actionMetadata.default) {
        command.push('$0');
      }

      if (CollectionUtil.isNotEmpty(command)) {
        program.command(
          command,
          actionMetadata.description || '',
          yargs => {
            if (actionMetadata.options) {
              actionMetadata.options.forEach((option: Option) => {
                yargs.option(option.key, option.options);
              });
            }
            return yargs;
          },
          async argv => {
            await groupContainer[actionMetadata.key](argv);
          }
        );
      }
    });
  });
}

export function cleanUpMetadata() {
  Reflect.defineMetadata(METADATA_KEY.group, [], Reflect);
}

export const DUPLICATED_GROUP_NAME = (name: string) => `Two groups cannot have the same name: ${name}`;
