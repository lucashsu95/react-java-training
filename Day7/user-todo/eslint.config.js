import globals from "globals";
import pluginJs from "@eslint/js";
import pluginReact from "eslint-plugin-react";

module.exports = {
  rules: {
    'react/react-in-jsx-scope': 'off', // 關閉此規則
    'react/prop-types': 'off',
  },
};

export default [
  { files: ["**/*.{js,mjs,cjs,jsx}"] },
  { languageOptions: { globals: globals.browser } },
  pluginJs.configs.recommended,
  pluginReact.configs.flat.recommended,
];