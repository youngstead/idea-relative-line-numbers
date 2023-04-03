# Relative Line Numbers Plugin

A plugin to display relative line numbers on IDEA-based IDEs.

# How to use

Simply install the plugin from the MarketPlace via the IDE or the website:
[JetBrains Marketplace](https://plugins.jetbrains.com/plugin/19193-relative-line-numbers)

# How it works

The line numbers on the gutter are replaced by relative values. If you want to
use the default line numbers you have to disable or uninstall the plugin.

![2022-05-19 16_43_26-idea-relative-line-numbers  H__Narduw_workspace_idea-relative-line-numbers – …_](https://user-images.githubusercontent.com/16376552/169325070-b6c6db64-3aea-4116-906f-59fd6d80fbc3.png)

# Why?

This is a simple lightweight solution to display relative line numbers in the
gutter.

## Why not [IdeaVim](https://github.com/JetBrains/ideavim)?

If you like VIM, then yes, go ahead and use IdeaVim. It does the same and much
more.
However, if you don't need or don't want to use all other features of IdeaVim,
this plugin offers a lightweight alternative to the
relative line numbers feature.

# Recognition

This plugin was inspired
by [@vayafulano's plugin](https://plugins.jetbrains.com/plugin/7414-relative-line-numbers).

## Why not use the @vayafulano's plugin instead?

Despite being outdated and not searchable via the IDE, you can still install it
by downloading the JAR file directly and installing it manually. However,
this solution uses annotations to display the line numbers, which has several
implications, including the following:

* Regular and relative line numbers may both be displayed simultaneously. This
  is not an issue per se but rather a side effect, outside the plugin's control.
* The relative line numbers may conflict with other annotations (e.g. VCS) and
  closing annotations will unintuitively remove the relative line numbers as
  well.

To address these issues, this plugin uses modern IntelliJ Platform SDK features
to replace line numbers with relative values. This should improve performance (
not measured) while avoiding conflicts with annotations.
