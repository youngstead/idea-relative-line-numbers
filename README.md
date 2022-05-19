# Relative Numbers Plugin
A plugin to display relative line numbers on IDEA-based IDEs.

This plugin was inspired by @vayafulano's [Relative Line Numbers plugin](https://plugins.jetbrains.com/plugin/7414-relative-line-numbers).

# Why?
This is a simple lightweight solution to display relative line numbers in the gutter.

## Why not IdeaVim?
If you like VIM, go ahead and use IdeaVim. It does the same and much more.
However, if you don't need or don't want to use all other features related to VIM, this plugin is a lightweight implementation.

## Why not use the original Relative Line Numbers plugin from @vayafulano?
Despite being outdated and not searchable via the IDE, you can still install vayafulano's plugin by downloading the jar file and installing it manuanlly. 

However. vayafulano's solution uses annotations to display the line numbers, which has several implications:

* Both the regular line numbers (if not hidden) and relative ones can be displayed at the same time. This is not an issue per se, but it is outside the plugin's control.
* The relative line numbers may conflict with other annotations (e.g VCS) and closing annotations will unintuitively remove the relative line numbers as well.

This plugin uses more modern Intellij Platform SDK features to replace the line numbers with relative values, which should brings some performance improvements as well.

# How to use
Simply install the plugin from the MarketPlace via the IDE or the website:
[JetBrains Marketplace](https://plugins.jetbrains.com/plugin/19193-relative-line-numbers)

# How it works
The line numbers on the gutter are replaced by relative values. If you want to use the default line numbers you have to disable or uninstall the plugin.

![2022-05-19 16_43_26-idea-relative-line-numbers  H__Narduw_workspace_idea-relative-line-numbers  – …_](https://user-images.githubusercontent.com/16376552/169325070-b6c6db64-3aea-4116-906f-59fd6d80fbc3.png)
