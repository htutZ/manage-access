# manage-access

Manage permission access for app

## Install

```bash
npm install manage-access
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`requestAllFilesAccessPermission()`](#requestallfilesaccesspermission)
* [`checkAllFilesAccessPermission()`](#checkallfilesaccesspermission)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### requestAllFilesAccessPermission()

```typescript
requestAllFilesAccessPermission() => Promise<void>
```

--------------------


### checkAllFilesAccessPermission()

```typescript
checkAllFilesAccessPermission() => Promise<{ hasPermission: boolean; }>
```

**Returns:** <code>Promise&lt;{ hasPermission: boolean; }&gt;</code>

--------------------

</docgen-api>
