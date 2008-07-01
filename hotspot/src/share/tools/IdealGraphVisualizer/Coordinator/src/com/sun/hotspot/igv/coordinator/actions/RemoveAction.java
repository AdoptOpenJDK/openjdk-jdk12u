/*
 * Copyright 2008 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 *
 */

package com.sun.hotspot.igv.coordinator.actions;

import javax.swing.Action;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.actions.NodeAction;

/**
 *
 * @author Thomas Wuerthinger
 */
public final class RemoveAction extends NodeAction {

    protected void performAction(Node[] activatedNodes) {
        for (Node n : activatedNodes) {
            RemoveCookie removeCookie = n.getCookie(RemoveCookie.class);
            if (removeCookie != null) {
                removeCookie.remove();
            }
        }
    }

    public RemoveAction() {
        putValue(Action.SHORT_DESCRIPTION, "Remove");
    }

    public String getName() {
        return NbBundle.getMessage(RemoveAction.class, "CTL_RemoveAction");
    }

    @Override
    protected String iconResource() {
        return "com/sun/hotspot/igv/coordinator/images/remove.gif";
    }

    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    @Override
    protected boolean asynchronous() {
        return false;
    }

    protected boolean enable(Node[] nodes) {
        return nodes.length > 0;
    }
}
